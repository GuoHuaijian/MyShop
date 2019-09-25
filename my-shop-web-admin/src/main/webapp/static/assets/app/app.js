var App = function () {

    var _masterCheckbox;
    var _checkbox;

    // 用于存放 ID 的数组
    var _idArray;

    var handlerInitCheckbox = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');
        _checkbox = $('input[type="checkbox"].minimal');
    };

    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            // 当前状态已选中，点击后应取消选择
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }

            // 当前状态未选中，点击后应全选
            else {
                _checkbox.iCheck("check");
            }
        });
    };

        /**
         * 批量删除
         */
        var handlerDeleteMulti = function (url) {
            _idArray = new Array();

            // 将选中元素的 ID 放入数组中
            _checkbox.each(function () {
                var _id =$(this).attr("id");
                if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                    _idArray.push(_id);
                }
            });

            // 判断用户是否选择了数据项
            if (_idArray.length === 0) {
                $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
            }
            else {
                $("#modal-message").html("您确定删除数据项吗？");
            }

            // 点击删除按钮时弹出模态框
            $("#modal-default").modal("show");

            // 如果用户选择了数据项则调用删除方法
            $("#btnModalOk").bind("click", function () {
                handlerDeleteData(url);
            });
        };


    /**
     * AJAX 异步删除
     * @param url
     */
    var handlerDeleteData = function (url) {
        $("#modal-default").modal("hide");

        if (_idArray.length > 0) {
            // AJAX 异步删除操作
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids" : _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件
                        $("#btnModalOk").unbind("click");

                        // 请求成功
                        if (data.status === 200) {
                            // 刷新页面
                            $("#btnModalOk").bind("click", function () {
                                window.location.reload();
                            });
                        }

                        // 请求失败
                        else {
                            // 确定按钮的事件改为隐藏模态框
                            $("#btnModalOk").bind("click", function () {
                                $("#modal-default").modal("hide");
                            });
                        }

                        // 因为无论如何都需要提示信息，所以这里的模态框是必须调用的
                        $("#modal-message").html(data.message);
                        $("#modal-default").modal("show");
                    }
                });
            }, 500)
        }
    };

    return{
        init:function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },

        getCheckbox:function () {
            return _checkbox;
        }
    }
}();

$(document).ready(function () {
    App.init();
});