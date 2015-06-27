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
	public static final String BATE_SESSION = ".eJy9WUtz2zYQ_isdnTM1XwBJ3zJNMumlmWbSU-3xgODSYsKHyodsJ-P_3l2QIkCIlCWn0wuHWIAfFvv4diH92PQtNHmV1ZvrHxshu7yu2s3135sGdnXTXYlebvM9tJs3m7wkyV2at2XetrgOZeMqqLrmSQ_T_GiFrHEJwpuSslQrBlw10UK3e9BbVfUedcsM5G3edrXaqsA3Lc_ySlQSDBVgJ5quRMUeAL5peW6N624LzVyEeuakl0hTLUwA9TXwlcVoVKKO-DId-REHXf21VhDdtgGYTU2DXVPXGQra_HG24OujLUErAZ14J-j5IO6hvSqhTKCZhjs0U52qDfOmA6juWlEIZafRlFlewHSm0XaT4essg6b53vyj1yNiVjflaFTRdVClNLiSoknnkl1fyW0qOoGrUZvGWl8XBSi_m8InWcDi8gLEHlbB0DV7KFanq7oUebE4BeWuqJ-ADrOV5AdAoHpHAaIdPi2_-769koVo204kBRxNtX25svxpd7y6wdBp0mUkCvCHuvl2mIVKQTe1GnWNUlgfqOknuUjLIcTwfYxBen3c3OIeRXFnpPKy00fw5clRD2PnQaNRgddRwSGQDbeU1rjtE7QVJnNnhd2ooLkUui6v7ikxdKyitMgs0X0jUrBkYof5t7el6NdyyBpTioddWItMdD8w0WKwY7KiyYrhgIfB_HQH6WApQyC3IL8ZYyFl3VfmiqSu-nYlik2ZSPdjBpvSBvY5PNhL2xbaVsVFLooFmj4uCKvUPpHjInUuUK7NymvsrWl-IEOVyuu8YhP6f0QzLxDeEUEa3HOCrI4q3CITz-n8uE6eLg-6wv5fhHaCU-1aRcTVgMA-5BlPlm6uQ6QMJCKksB-bXzpispuehZm46cMocG76IAP3pucOx4zHJbLGNL8eCa0SJQ1wmiW4lEUx4DNgET5TYFR4O9H17R1t5D6_mT4fiWb6Xn8z33Dt-4lCNUKSSXy6nF2OdhQU-lyhQ0gg-BoqPj2Bkiji0Ys7HGhba630jZxAzvEvwDS5f8IN4yT5SdyJkgwnEwQDP7oIyOAyDRVxn57BZVAGCRqho1wUOHjUEPtAfCYhXAQ7MukEGYAn6JmIV3t6ouMJNMo4asgTdXA_xXSJ3di7CPRAscvhE2YxviciVdagp8_I5ZHEvcLU887cxawchpX56Co1fa5huznO719MpHMD3C5Tk1KxAwgVM4heAaurnHaRMhLzhDuZMGMnWEwTvbaT59JnsUzI_i5_-46oSXJiU8d9idDmvd4it61l9vmsaRYynZBeGFNEykxBgYok7xTs7S0hHyrGkCyDQtxLlYosOqtifPrw4f3nObq3WirUYkpx8lEYOHz9w1M14oU95_Xf4AVHMYLnDDE2pJgNMzdMxIQgw1Lym1prwwxNllZSuTNKg-CQwcxPyQfMh_lWvqHxoevXMBAGRIiStIwZ1S9foibIBv6g1TqY1d7o_DDOwsMAcWLOyBZJggETZvyEglaPtIg55nDoZudhHt_DR1jXPwCv285yk0NmYR4Ea25ab4D1WQyQc84SGGdZ7mStqOAsI0d6Pp9n3IUbjM2zkfyM9Pa5q6CcJd5bgVpo8bU5kixEKCcIL4ZduhuYtqD6ziS7GHfhUqHVjTj7KVvYdw2TN9IpFI3SHzsCaDabufM8F0534MXo45KMzh0_sdHmYY8NU0ympD5sOewX70e6zzS-557rHCSaaef7M2t_s4IN9kGvMnP_pcu3jgSj59Hq_00-iwgxc5wB93auBp-pkYp2m9QqJ_S-6tI7bvTx_dt3v336648vg0lxx1habgqPDKsMoHrTS7jFvhNqS_vU2rIwsjwaLcbH0TVQ57pPkTegHfdJ62j2ldPoeIQzAU4Jcxn4_K67GNGvhR4u3RclSTTz5Z8fP88JVrttIdW1fw_BvdaquI5jtpK9dfRYBqqbjM9FGH9pNFJTDg0AnTFMOD0jOnXk2n3oDGf8UdK4AsfqMuQrzg0dCiGO73EUnq3b-LumcbqUbiNe6J1GQD_cDr-KDiJ87x7V60Zuobrf1tX9r9teqB8oyQBqjn7ZoP9b9D1BmQJb3IyYKco2z8__AkqphEY.CD0lfQ.72eOg39uKnoIU7-2dW3Lxh_7p9E";
	public static final String BATE_OIDS = "43777,43780,43778,43776,43779,43781,43782,43783,43784,43785,43788,43786,43787,43791,43794,43792,43793,43795,43796,43797,43798,43799,43800,43802,43801,43803,43804,43805,43806,43789,43807,43808,43790,43809,43810,43811,43812,43813,43814,43815,43820,43816,43817,43818,43819";
	
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
		
		url = BATE_URL;
		domain = BATE_DOMAIN;
		session = BATE_SESSION;
		oids = BATE_OIDS.split(",");
		
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
		CloseableHttpResponse response = null;
		HttpPost post = null;
		for (String oid : oids) {
			CloseableHttpClient client = HttpClients.createDefault();
			post = new HttpPost(url + oid);
			response = client.execute(post, context);
			if(response.getStatusLine().getStatusCode() == 200){
				System.out.println(MessageFormat.format("删除{0}成功", new Object[]{oid}));
			}else{
				break;
			}
			client.close();
		}
	}

}
