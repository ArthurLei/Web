package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorFilter implements Filter {
    FilterConfig config = null;
    String encoding=null;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        if(encoding!=null){
            //设置request字符编码
            request.setCharacterEncoding(encoding);
            //设置response字符编码
            response.setContentType("text/html;charset="+encoding);
        }
        //传递给下一个过滤器
        chain.doFilter(request, response);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        config = filterConfig;
        encoding=filterConfig.getInitParameter("encoding");
    }
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        encoding=null;
        config = null;
    }

}
