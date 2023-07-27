package com.motorworld.cars.webfilters;

public class AuthorizationFilter extends RequestContextFilter {

@Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) 
                        throws IOException, ServletException {

                            System.out.println("This is a web filter");
    
    }

}