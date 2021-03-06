 //JS 问题如何解决? console.log(),debugger,排除
   $(function(){
	//$("#pageId").load("doPageUI",doGetObjects);
	  //debugger
	  doGetObjects(); 
	 
	  //事件注册
	  $(".input-group-btn")
	  .on("click",".btn-search",doQueryObjects)
	  .on("click",".btn-delete",doDeleteObjects)
	  //thread中checkbox对象(全选)事件注册
	  $("#checkAll").change(doChangeTBodyCheckBoxState);
	  //tbody中checkbox对象事件注册
	  $("#tbodyId")
	  .on("change","input:checkbox",doChangeTHeadCheckBoxState);
   })
   //处理tbody中checkbox对象的事件
   function doChangeTHeadCheckBoxState(){
	  //1.定义一个初始状态，默认值true.
	  var flag=true;
	  //2.获得所有tbody中的checkbox对象并与flag变量的初始状态进行逻辑与操作
	  $("#tbodyId input:checkbox")
	  .each(function(){
		  flag=flag&&$(this).prop("checked");
	  });
	  //3.修改thead中checkbox状态
	  $("#checkAll").prop("checked",flag);
   }
   //处理thead中checkbox对象的事件
   function doChangeTBodyCheckBoxState(){
	   //1.获得head中checkbox对象的状态
	   var flag=$(this).prop("checked");
	   //2.修改tbody中checkbox对象状态
	   $("#tbodyId input:checkbox").prop("checked",flag);
   }
   //获取选中的记录id
   function doGetCheckedIds(){
	   //1.定义数组
	   var idArray=[];
	   //2.迭代所有选中的checkbox对象，并获取value属性的值，然后存储到数组
	   $("#tbodyId input:checkbox:checked")
	   .each(function(){
		   idArray.push($(this).val());
	   });
	   //3.返回数组
	   return idArray;
   }
   //定义日志删除事件处理函数
   function doDeleteObjects(){
	   //1.获取选中记录id
	   var idArray=doGetCheckedIds();//通过此函数返回一个数组，数组中存储的是选中的记录id
	   if(idArray.length==0){
		   alert("请先选择");
		   return;
	   }
	   if(!confirm("确认删除吗"))return;
	   //2.并构建参数对象
	   var params={"ids":idArray.toString()};//[1,2,3]-->1,2,3
	   //3.定义删除操作的url
	   const url="log/doDeleteObjects";
	   //4.发送异步请求执行删除操作，并刷新页面
	   $.post(url,params,doHandleDeleteResult)
   }
   //处理删除结果
   function doHandleDeleteResult(result){
	   if(result.state==1){
		   alert(result.message);
		   //doGetObjects();//刷新
		   doRefreshAfterDeleteOK();
	   }else{
		   alert(result.message);
	   }
   }
   //执行删除操作以后的刷新操作
   function doRefreshAfterDeleteOK(){
	   var checkAll=$("#checkAll").prop("checked");
	   var pageCurrent=$("#pageId").data("pageCurrent");
	   var pageCount=$("#pageId").data("pageCount")
	   if(checkAll&&pageCurrent==pageCount&&pageCount>1){
		   pageCurrent--;
		   $("#pageId").data("pageCurrent",pageCurrent);
	   }
	   doGetObjects();
   }
   //基于参数查询日志信息
   function doQueryObjects(){
	   //初始化当前页码值
	   $("#pageId").data("pageCurrent",1);
	   //执行查询
       doGetObjects();
   }
   //通过此函数异步加载服务端的日志信息
   function doGetObjects(){
	 //初始化全选checkbox对象状态
	 $("#checkAll").prop("checked",false);
	 //1.定义请求参数
	 var pageCurrent=$("#pageId").data("pageCurrent");
	 if(!pageCurrent)pageCurrent=1;
	 var uname=$("#searchNameId").val();
	 //参数封装：方法1
	 //let params="pageCurrent="+pageCurrent;
	 //if(uname)params=params+"&username="+uname;
	 //参数封装：方法2
	 let params={"pageCurrent":pageCurrent};//json格式的js对象
	 if(uname)params.username=uname;
	 //2.定义请求url
	 const url="log/doFindPageObjects";
	 //3.发送异步请求并处理响应结果
	// $.getJSON(url,params,function(result){//JsonResult
	//	 doHandleQueryResult(result);
	 //});
	 //也可以按照如下结构进行异步请求
	 $.getJSON(url,params,doHandleQueryResult)
   }
   function doHandleQueryResult(result){//JsonResult
	   //debugger
	   //console.log("result",result);
	   if(result.state==1){//正常数据
		   //第一步:将当前页的日志记录信息更新到页面上
		   //console.log(result.data.records)
		   doSetTableBodyRows(result.data.records);
		   //第二步:将分页信息更新到页面上
		   doSetPagination(result.data);
	   }else{
		   //alert(result.message);
		   doSetQueryErrors(result.message);
	   }
   }
   function doSetQueryErrors(message){
	   $("#tbodyId").html(`<tr><td colspan='7'>${message}</td></tr>`);
   }
   
   function doSetTableBodyRows(records){//List<SysLog>
	   //1.获取tbody对象并清空内容
	   var tBody=$("#tbodyId");
	   tBody.empty();
	   //2.遍历records并将结果更新到页面上。
	  //for(var i=0;i<records.length;i++){
		   //1.构建一行tr对象
		   //var tr=doCreateRow(records[i]);
		   //2.将tr追加tbody中
		   //tBody.append(tr);
	  //}
	   records.forEach(record=>tBody.append(doCreateRow(record)))
   }
   function doCreateRow(record){
	   return `<tr>
	            <td><input type='checkbox' class='cItem' value=${record.id}></td>
	            <td>${record.username}</td>
	            <td>${record.operation}</td>
	            <td>${record.method}</td>
	            <td>${record.params}</td>
	            <td>${record.ip}</td>
	            <td>${record.time}</td>
	       </tr>`;
   }