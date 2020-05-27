package az.com.course.client;

import az.com.course.bean.person.PersonResponseBean;
import az.com.course.bean.token.TokenRequestBean;
import az.com.course.bean.token.TokenResponseBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class Client {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        TokenRequestBean tokenRequestBean = new TokenRequestBean();
        tokenRequestBean.setUsername("Taleh");
        HttpEntity<TokenRequestBean> tokenRequestBeanHttpEntity = new HttpEntity<>(tokenRequestBean);
        String token = restTemplate.exchange("http://localhost:8081/course/auth/token",
                HttpMethod.POST, tokenRequestBeanHttpEntity, TokenResponseBean.class).getBody().getToken();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        PersonResponseBean body = restTemplate.exchange("http://localhost:8081/course/person/",
                HttpMethod.GET, httpEntity, PersonResponseBean.class).getBody();
        System.out.println(body);

    }
}
