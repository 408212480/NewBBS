/*
* 分页js
* */

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
/*
* 表单验证
* */
$(function () {
    $("#login").validate({
        rules:{
            username:{
                required:true
            },
            password:{
                required:true,
                number:true
            }
        },
        messages:{
            username:{
                required:"用户名不能为空!"
            },
            password:{
                required:"密码不能为空!",
                number:"密码必须是整数!"
            }
        },
        errorElement:"label"
    })
    $("#registered").validate({
        rules:{
            username:{
                required:true
            },
            password:{
                required:true
            },
            repassword:{
                required:true,
                equalTo:"[name='password']"
            },
            email:{
                required:true,
                email:true
            }

        }
    })
});

/*
* 登陆界面切换
* */
function showchange(object) {
    var $name=$(object).attr("id");
    if ($name=="login_button"){
        $("#registered").css("display","none");
        $("#login").css("display","block");
    }else if ($name=="register_button"){
        $("#login").css("display","none");
        $("#registered").css("display","block");
    }
}

