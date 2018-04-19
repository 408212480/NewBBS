function getPage(pno) {
//            count代表总共的数据数目
    var countValue=document.getElementById("count").innerHTML;
    var totalPage;
//           除有余说明还有页数加一
    if (countValue%3>0){
        totalPage=(countValue/3)+1;
    }else {
        totalPage=(countValue/3);
    }
    totalPage=Math.floor(totalPage);
    document.getElementById("totalPage").innerHTML=totalPage;
    var currentPage=arguments[0];
    var temStr="";
//》1说明是第一页
    if (currentPage>1){
        temStr+="<button onClick=\"getPaget(1)\">首页</button>";
        temStr+="<button onClick=\"getPaget("+(currentPage-1)+")\">上一页</button>";
    }
    for(var pageIndex=1;pageIndex<= totalPage;pageIndex++){
        temStr+="<button onClick=\"getPage("+pageIndex+")\">"+pageIndex+"</button>";

    }
//            尾页
    if(currentPage!=totalPage){
        temStr+="<button onClick=\"getPaget("+(currentPage-1)+")\">下一页</button>";
        temStr+="<button onClick=\"getPaget("+totalPage+")\">尾页</button>";
    }
    document.getElementById("barcon").innerHTML=temStr;


}