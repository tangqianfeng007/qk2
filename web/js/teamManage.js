//团队管理
jQuery(document).ready(function ($) {
    //创建团队
    $("#createTeam").click(function () {
        $('#myModal').modal('toggle');
    });
    //提交创建团队表单
    $("#createSubmit").click(function () {
        var vtName = $("#vtName").val();
        if (vtName == "" || vtName == null || !vtName) {
            alert("请输入团队名称");
            return;
        }
        var jsonInfro = $("#createTeamForm").serializeObject();
        jQuery.ajax({
            type:'post',
            url:'/ajax/createTeam.action',
            processData:true,
            async:true,
            dataType:'html',
            data:jsonInfro,
            success:function (data) {
                data = jQuery.parseJSON(data);
                if (data.status == 1) {
                    $('#myModal').modal('toggle');
                    alert("团队创建成功");
                    location.reload();
                }
                else {
                    alert("团队创建失败" + data.status);
                }
            },
            error:function () {
                alert("服务器繁忙中！稍后再试！");
            }
        });
    });


    $("#manageMembers").click(function () {
        var rfpInfoId = $("#rfpInfoId").val();

        var htmlobj = $.ajax({url:"/rfp/getTeamAndMembers.action", data:{rfpId:rfpInfoId}, cache:false, async:false});
        $("#memberList").html(htmlobj.responseText);
        $('#myModal2').modal('toggle');
    });


    //提交成员变化表
    $("#changeMember").click(function () {
        var tds = $("#inTable .uId");//所以的id
        var uerIdList = "";
        if (tds.length > 0) {
            uerIdList = $(tds[0]).html();
            for (var i = 1; i < tds.length; i++) {
                uerIdList = uerIdList + "," + $(tds[i]).html();
            }
        }
//        alert(uerIdList);
        var teamId = $("#vtId").val();
        jQuery.ajax({
            type:'post',
            url:'/ajax/addRFPMemberList.action',
            processData:true,
            async:true,
            dataType:'html',
            data:{addUserIds:uerIdList, teamId:teamId},
            success:function (data) {
                data = jQuery.parseJSON(data);
                if (data.status == 1) {
                    alert("修改成功");
                    location.reload();
                }
                else {
                    alert("修改失败" + data.status);
                }
            },
            error:function () {
                alert("服务器繁忙中！稍后再试！");
            }
        });
        $("#memberList").html("");
        $('#myModal2').modal('toggle');
    });
});

function exchangeTr(obj) {
    var myTr = $(obj).parent().parent();
    var inTable = $("#inTable");
    var outTable = $("#outTable");
    var bvalue = $(obj).html();
    if (bvalue == "添加") {
        $(obj).html("删除");
        $(inTable).append("<tr>" + (myTr).html() + "</tr>");
    }
    else if (bvalue == "删除") {
        $(obj).html("添加");
        $(outTable).append("<tr>" + (myTr).html() + "</tr>")
    }
    myTr.remove();
}