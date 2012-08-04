package za.co.trf.recurly.api.implementation;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import za.co.trf.recurly.KeyProvider;

import java.util.Collections;
import java.util.List;

public class RecurlyRestTemplate extends RestTemplate {

    protected final Logger log = Logger.getLogger(getClass());

    public RecurlyRestTemplate(KeyProvider keyProvider) {
        this(keyProvider.getPrivateKey());
    }

    public RecurlyRestTemplate(String apiKey) {
        // TODO httpParams
        DefaultHttpClient client = new DefaultHttpClient();
        Credentials credentials = new UsernamePasswordCredentials(apiKey, ""); 
        client.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
        setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));
    }

    public <T> void putXml(String url, T entity, Class<T> clazz, String...args) {
        put(url, entity, clazz, MediaType.APPLICATION_XML, args);
    }

    public <T> void put(String url, T entity, Class<T> clazz, MediaType mediaType, String...args) {
        List<MediaType> acceptableMediaTypes = Collections.singletonList(mediaType);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);

        HttpEntity<T> httpEntity = new HttpEntity<T>(entity, headers);

        ResponseEntity<T> response = exchange(url, HttpMethod.PUT, httpEntity, clazz, args);

        log.debug("Response Code: " + response.getStatusCode());
    }

    public void deleteXml(String url, String...args) {
        delete(url, MediaType.APPLICATION_XML, args);
    }

    public void delete(String url, MediaType mediaType, String...args) {
        List<MediaType> acceptableMediaTypes = Collections.singletonList(mediaType);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);

        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<Void> response = exchange(url, HttpMethod.DELETE, httpEntity, Void.class, args);

        log.debug("Response Code: " + response.getStatusCode());
    }

}
