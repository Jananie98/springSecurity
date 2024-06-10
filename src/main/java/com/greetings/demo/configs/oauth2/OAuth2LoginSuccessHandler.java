package com.greetings.demo.configs.oauth2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final CustomerRepository customerRepository;
    private final JwtUtil jwtUtil;

    public OAuth2LoginSuccessHandler(CustomerRepository customerRepository, JwtUtil jwtUtil) {
        this.customerRepository = customerRepository;
        this.jwtUtil = jwtUtil;

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, ServletException, IOException {
        Object principal = authentication.getPrincipal();
        String jwtToken = null;
        if (principal instanceof CustomerAuth2User) {
            CustomerAuth2User oauth2User = (CustomerAuth2User) principal;
            String email = oauth2User.getAttribute("email");
            String userName = oauth2User.getAttribute("name");

//            if (!customerRepository.existsCustomerByEmail(email)) {
//                Customer customer = new Customer();
//                customer.setFirstName(userName);
//                customer.setEmail(email);
//                customer.setPassword("Dummy");
//                customer.setVerified(true);
//                customer = customerRepository.save(customer);
//            }
//            Customer customer = customerRepository.findCustomerByEmail(email);
//            jwtToken = jwtUtil.generateToken(customer);

            if (jwtToken != null) {
                // Send the JWT token in the response
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"token\": \"" + jwtToken + "\"}");
                System.out.println(request);
                System.out.println(response);
                System.out.println(authentication);
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else {
            System.out.println("Principal is not an instance of DefaultOAuth2User");
        }
    }
}
