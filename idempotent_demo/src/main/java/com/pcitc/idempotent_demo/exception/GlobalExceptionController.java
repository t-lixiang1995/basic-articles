package com.pcitc.idempotent_demo.exception;

import com.pcitc.idempotent_demo.exception.classify.BusinessException;
import com.pcitc.idempotent_demo.result.RetResult;
import com.pcitc.idempotent_demo.result.RetResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lixiang
 * @date 2020/5/6 11:03
 * @desc 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionController.class);

    public static final String DEFAULT_ERROR_VIEW = "error";
    /**
     * 方法描述: 默认的异常处理(在每个项目的Template下要创建error.html)
     * 参数:     @param req
     * 参数:     @param e
     * 参数:     @return
     * 参数:     @throws Exception
     * 返回:     ModelAndView
     * 创建人:    wjx
     * 创建时间:  2018年3月14日 下午5:02:23
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOGGER.error("系统出现未知异常,异常名称[{}]，异常描述[{}]",e.getClass().getName(),e.getStackTrace());
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);

        return mav;
    }

    /**
     * 方法描述:自定义业务逻辑异常处理
     * 参数:   @param req
     * 参数:   @param e
     * 参数:   @return
     * 返回:   ReturnJsonResult
     * 创建人:  wjx
     * 创建时间:2018年3月14日 下午5:04:46
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public RetResult<String> resultExcepitonHandler(BusinessException businessException) {
        RetResult<String> retResult;
        if(businessException.getCause()!=null){
            LOGGER.error("业务逻辑出现异常，异常描述[{}],异常原因[{}]",businessException.getMsg(),businessException.getCause().getMessage());
            retResult = RetResultUtil.remark(businessException.getCode(),businessException.getMsg(),businessException.getCause().getMessage());
        }else{
            LOGGER.error("业务逻辑出现异常，异常描述[{}],异常原因未描述",businessException.getMsg());
            retResult = RetResultUtil.remark(businessException.getCode(),businessException.getMsg());
        }
        return retResult;

    }
}

