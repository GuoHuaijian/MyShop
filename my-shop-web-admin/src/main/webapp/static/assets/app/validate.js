/**
 * 函数对象
 */
var validate = function () {

    var handlerInitValidate = function () {
        $.validator.addMethod("mobile", function(value, element) {
            var length = value.length;
            var mobile =  /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");
        $("#inputForm").validate({
            errorElement: 'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });
    };

    return{
        init:function () {
            handlerInitValidate();
        }
    }
}();

$(document).ready(function () {
    validate.init();
});