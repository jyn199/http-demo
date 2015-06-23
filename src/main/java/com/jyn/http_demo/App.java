package com.jyn.http_demo;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;

/**
 * Hello world!
 * 
 */
public class App {

	//BATE
	public static final String BATE_URL = "http://l-corehr3.ops.beta.cn0.qunar.com:10015/hr/1/remove/";
	public static final String BATE_DOMAIN = "l-corehr3.ops.beta.cn0.qunar.com";
	public static final String BATE_SESSION = "";
	public static final String BATE_OIDS = "";
	
	//DEV
	public static final String DEV_URL = "http://l-backyard1.ops.dev.cn6.qunar.com:10088/hr/1/remove/";
	public static final String DEV_DOMAIN = "l-backyard1.ops.dev.cn6.qunar.com";
	public static final String DEV_SESSION = ".eJy9WVlv3DYQ_iuFno1aF3UY6EPaJE2BNEXTpG0cGwuKorxydFXH2uvA_70zlFakuNJ61yn6IojD0cfhHB-Hu1-NVcXrnBa8aI2Ltu74mUE3tKW1cfHV-C4yLoy3zjvz09_vq0_b8IHlv27oX9b60v7z4a3z4zayL6vo54_tZf769vIPchfl7Afj8cxgXV0D4qprOAAZVx0JY3bVecwJ4D1JiHFm5Lxdl_G4DH5Wt_erFETGtixuipQW39_C4waUESgtkhLVKWvTsmiMi89Gzauybs9px9bphjegmOYoWcVpk6dNA3ogG7TAoHorh3G6p8FKUAF4VZLnQqPHFRMNb6s7uVRRbsC2REFep01biqUyeJPyJC1owbhiAq9o3eZg2B3nX6Q81cZlu-b1VAR2pmgXjWMpjDjYq-ALj-EoBxvhZdzyPQza8rYUEO265nwyNQ6quiwTEDTp_UTh9l6XDM6AZEpKzCexTdq2vIhxcM5oHU8lVVewdQypBtr0BvJkql9mGReRUIVblvFZ9YzTDV8EA2dteLY4XZQ5TbPZKZ5XWbnlwnkcMMoKozV6nxddjg4uM9Roa6EogepulNM4750N70M08BVdBwnGMVkqis87-LY5z3keCYh-CG5Ny1jEKq1bzotVQzMqUmxwfJKKpfp0GNJuzNkySXhdP9T_wPuaTXa4elifs4w2TUujjO9NNWJ_c-rbal-7hvyr43kkrJK7sv7Sz17DdJatlFKet3xw6fzk4H3F330cBrc_jwp20VCSINfGTRfBNqGYWy3JBwNVVd62qWAwpTJAmiWa6KamMddktIL62-hSCEneh16VwmZndIGJbnommi0tyDhwWdZvcDeY7m4n7T2lCNiasy_KmDJWdoWqEZVF1ywUjiqj8WbgC1Va803K73TVpuFNI_IipdkMTe8fCIvUPpLjLHXOUK7OykvsLWm-r2it4nQW0wn9PyK1J-h1j44VpjtAjXsn3CzvTzlp_5w8zHHyhP1_uOggHeqEi8RVcwqMBW_Yq9gOtjJFBxLoZFqkMmhx_IRedX7gmledm3ALWh_Tg5IHFVZCnV8MjFbQnIv-yCMRqJIg5PB0CXZJMccuCQxpu0Z0Rdbj2fj5wDTj9_Kb6YJL348cKhGiBDo0YnnkdLS9rJD78k1E4tRbQoWnTUESBF7w5Ao73pZWC3sD02VT_BMwVfIfcf0wir4Rd-QkJcgIQTg2wScAKWQmoQLPwad7GpTCgkrqiBC5JmzVh0YQnpHPT4IdqHSEdLlN8RnRZ0d65OMRNEg8vEJEYuNODOUSWqF9EuiOY-fTx09CeI9oLLyBT4dgyAMGa_mxbR-5inp0KF72hlCJ6WMd205xfvmgIh2b4Po5NRoVmhygQsKDZ8DKY06GSDiJ2NQaXZiQAywmmV76ybbws5BF6H_Le_ESqYl5yKam9RShTZu9WW5bquzjWVM9yWRB2n6IGckSAcVFJtmHYK-vEXl3YvTF0hvk2bEwkQRHnRi_vX796v0U3V48KoQyljjGyHdNb_nDQ2fEE2tOGwCFF0zBCLbZ51hfYjrM1DEBoRQdi8WvWi0d03dZ0kgRziB23V0FEyfGGBCHT5dyFIt3bb-E4b6LhMjQypDg-eUwsATYwOmtWgbT-htZH8pePN8FnNAj6IsogoTxE--AgVqTNIs51LBvJcdh7t8mB1jL2QEv-04Lk4luITZ3l8K03AHLvSggx-zFVfYy38pqWeGRBANpO9604k5cYOieleInaLfjWQLKnOO9BaiZHl-6I0p8gDJd_2TYucuB6gs83wkjJ-PO3CqkuYFHvskX-mVD5Y14TEXl6A9NynE2mYTzuBCOl-DZ7PMYOt0znUhHm6Y9NEwhuhL7sPm0n70gyT5T-d6zLXMnkUw7XZ9o66snWO8fiCpR15-7fctMUHoeaf5njFmAiIlp9rjXUzO8iRkxbdZRKWpCrituvcNCb169ePnTbx_ffehdCiuGTAuTv-dY4QDRm57CLfqlUHrawdaW-IEW0WA2P_bugbLWHcy8Hm2_T1pG0--cSsdDzRFwLJjTwKeX3dmMfi50f-s-qUiCSSx_f_N-SrAybDOlLuO7S-6lVsUyTbWV7LSth8wV3WR4LMLwU6NSmqxvAHCPfuThM8BdB5beh05whl8llStwKC5DjuBc38QU8uA9DPyjbRt-2FR2F-NtxPbtwwgQh-v-Z9FedOgvFty_mMJfNvD_lmE1TfHx8V9vvLo0.CGq2Wg.T3UFy0rlQteKFKATsqQq4_e5tds";
	public static final String DEV_OIDS = "26642";
	
	
	public static String url = null;
	public static String domain = null;
	public static String session = null;
	public static String[] oids = null;
	
	private static HttpClientContext context;
	
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		
		url = DEV_URL;
		domain = DEV_DOMAIN;
		session = DEV_SESSION;
		oids = DEV_OIDS.split(",");
		
		context = HttpClientContext.create();
		BasicCookieStore cookieStore = new BasicCookieStore();
		BasicClientCookie cookie = new BasicClientCookie("session", session);
		cookie.setVersion(0);
		cookie.setDomain(domain);
		cookie.setPath("/");
		cookieStore.addCookie(cookie);
		context.setCookieStore(cookieStore);
		
		post(oids);
	}

	private static void post(String[] oids) throws ClientProtocolException,
			IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		for (String oid : oids) {
			HttpPost post = new HttpPost(url + oid);
			response = client.execute(post, context);
			if(response.getStatusLine().getStatusCode() == 200){
				System.out.println(MessageFormat.format("删除{0}成功", new Object[]{oid}));
			}
		}
		client.close();
	}

}
