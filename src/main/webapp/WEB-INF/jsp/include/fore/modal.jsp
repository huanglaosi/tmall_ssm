<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%--
dialog用于指定拟态框为对话框
--%>
<div class="modal" id="loginModal" tabindex="-1" role="dialog">
    <div class="modal-dialog loginDivInProductPageModalDiv">
        <div class="modal-content">
            <div class="loginDivInProductPage">

                <div class="loginErrorMessageDiv">
                    <div class="alert alert-danger">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        </button>
                        <span class="errorMessage"></span>
                    </div>
                </div>

                <div class="login_acount_text">账号登陆</div>

                <div class="loginInput">
                    <span class="loginInputIcon">
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                    <input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">
                </div>

                <div class="loginInput " >
                            <span class="loginInputIcon ">
                                <span class=" glyphicon glyphicon-lock"></span>
                            </span>
                    <input id="password" name="password"  type="password" placeholder="密码">
                </div>

                <span class="text-danger">不要输入真实的天猫账号密码</span><br><br>

                <div>
                    <a href="#nowhere">忘记登录密码</a>
                    <a href="register.jsp" class="pull-right">免费注册</a>
                </div>

                <div style="margin-top:20px">
                    <button class="btn btn-block redButton loginSubmitButton" type="submit">登录</button>
                </div>

                </div>

            </div>
        </div>
    </div>

<div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog" >
    <div class="modal-dialog deleteConfirmModalDiv">
        <div class="modal-content">
            <div class="modal-header">
                <%--属性 aria-hidden="true" 用于保持模态窗口不可见，直到触发器被触发为止（比如点击在相关的按钮上）。
class="close"，close 是一个 CSS class，用于为模态窗口的关闭按钮设置样式。
data-dismiss="modal"，是一个自定义的 HTML5 data 属性。在这里它被用于关闭模态窗口。
class="modal-body"，是 Bootstrap CSS 的一个 CSS class，用于为模态窗口的主体设置样式。
class="modal-footer"，是 Bootstrap CSS 的一个 CSS class，用于为模态窗口的底部设置样式。
data-toggle="modal"，HTML5 自定义的 data 属性 data-toggle 用于打开模态窗口。
                --%>
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">确认删除？</h4>
            </div>

            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
            </div>
        </div>
    </div>
</div>
</div>