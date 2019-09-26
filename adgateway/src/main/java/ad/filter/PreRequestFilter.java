package ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * Created by Qinyi.
 */
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {

    /**
     * 定义filter类型 一般有四种
     *     public static final String ERROR_TYPE = "error";
     *     public static final String POST_TYPE = "post";
     *     public static final String PRE_TYPE = "pre";
     *     public static final String ROUTE_TYPE = "route";
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 定义执行顺序，数字越小，越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行，可以用于某些特定的情况执行 ,true执行，flase不执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        //zuul提供的请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime", System.currentTimeMillis());

        return null;
    }
}
