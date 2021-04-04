package com.goudong.module.exception;

import com.goudong.module.enumerate.ClientExceptionEnum;
import com.goudong.module.enumerate.ServerExceptionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * 类描述：
 * 自定义异常的基类，其它模块的异常继承进行扩展
 * @ClassName BaseicException
 * @Author msi
 * @Date 2020/6/10 19:41
 * @Version 1.0
 */
@Getter
@ApiModel(value = "BasicException", description = "出现异常，返回的消息")
public class BasicException extends Exception{
    /**
     * http 响应码
     */
    private int status;
    /**
     * 错误代码
     */
    private String code;
    /**
     * 客户端状态码对应信息
     */
    @ApiModelProperty(value = "状态码对应描述", required = true, example = "用户不存在")
    private String clientMessage;

    /**
     * 服务器状态码对应信息
     */
    @ApiModelProperty(value = "状态码对应描述", required = true, example = "用户不存在")
    private String serverMessage;

    /**
     * 构造方法
     * @param status http状态码
     * @param code 自定义状态码
     * @param clientMessage 客户端显示信息
     * @param serverMessage 服务端日志显示信息
     */
    public BasicException(int status, String code, String clientMessage, String serverMessage) {
        super(clientMessage+"\n"+serverMessage);
        this.status = status;
        this.code = code;
        this.clientMessage = clientMessage;
        this.serverMessage = serverMessage;
    }

    /**
     * 客户端误操作造成异常
     * @param exceptionEnum
     */
    public BasicException(ClientExceptionEnum exceptionEnum) {
        this(exceptionEnum.getStatus(), exceptionEnum.getCode(), exceptionEnum.getClientMessage(), exceptionEnum.getServerMessage());
    }

    /**
     * 服务端异常
     * @param exceptionEnum
     */
    public BasicException(ServerExceptionEnum exceptionEnum) {
        this(exceptionEnum.getStatus(), exceptionEnum.getCode(), exceptionEnum.getClientMessage(), exceptionEnum.getServerMessage());
    }

    /**
     * 类描述：
     *  客户端内部错误
     * @ClassName ParamterInvalidException
     * @Author msi
     * @Date 2020/7/14 20:40
     * @Version 1.0
     */
    public static class ClientException extends BasicException {

        public ClientException(ClientExceptionEnum clientExceptionEnum) {
            super(clientExceptionEnum);
        }
    }

    /**
     * 类描述：
     *  服务器内部错误
     * @ClassName ServerException
     * @Author msi
     * @Date 2020/7/14 20:40
     * @Version 1.0
     */
//    public static class ServerException extends BasicException {
//        public ServerException(ServerExceptionEnum serverExceptionEnum) {
//            super(serverExceptionEnum);
//        }
//    }

}
