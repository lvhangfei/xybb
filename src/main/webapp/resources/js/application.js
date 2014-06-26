//
var load_icon = "<i class='icon-spinner icon-spin'></i>";


//校验邮箱格式
function isEmail(emailName) {
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (filter.test(emailName)) return false;
    return true;
}

//校验密码：只能输入6-20个字母、数字、下划线
function isPasswd(password) {
    var patrn = /^(\w){6,20}$/;
    if (patrn.test(password)) return false;
    return true;
}

/**
 * dom不可用，显示加载中
 * @param id            dom-ID
 * @param isDisabled    是否显示
 * @param msg           附加的信息
 */
function obj2Disabled(id, isDisabled, msg) {
    var obj = $("#" + id);
    if (isDisabled) {
        obj.html(msg + load_icon);
        obj.addClass("disabled");
    } else {
        obj.html(msg);
        obj.removeClass("disabled");
    }
}
