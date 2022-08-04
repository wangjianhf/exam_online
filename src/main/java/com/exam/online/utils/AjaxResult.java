package com.exam.online.utils;


import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化AjaxResult对象，使其表示一个空值
     */
    public AjaxResult() {

    }

    /**
     * 初始化AjaxResult对象
     */
    public AjaxResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化AjaxResult对象
     */
    public AjaxResult(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (null != data) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功信息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功信息
     */
    public static AjaxResult success(Object data) {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功信息
     */
    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功信息
     */
    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(HttpStatus.HTTP_OK, msg, data);
    }

    /**
     * 返回错误信息
     */
    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 回错误信息
     */
    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg, null);
    }

    /**
     * 回错误信息
     */
    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(HttpStatus.HTTP_INTERNAL_ERROR, msg, data);
    }

    /**
     * 回错误信息
     */
    public static AjaxResult error(int code, String msg) {
        return new AjaxResult(code, msg, null);
    }
}
