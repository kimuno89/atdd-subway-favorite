package nextstep.subway.auth.ui.interceptor.authorization;

import static nextstep.subway.auth.infrastructure.SecurityContextHolder.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nextstep.subway.auth.infrastructure.SecurityContext;
import nextstep.subway.auth.infrastructure.SecurityContextHolder;

public class SessionSecurityContextPersistenceInterceptor extends SecurityContextInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        SecurityContext securityContext = (SecurityContext)request.getSession()
            .getAttribute(SPRING_SECURITY_CONTEXT_KEY);
        if (securityContext != null) {
            SecurityContextHolder.setContext(securityContext);
        }
        return true;
    }
}
