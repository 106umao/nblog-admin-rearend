import club.bangju.util.RsaUtils;
import org.junit.Test;

public class RsaGenerateKeyTest {
    @Test
    public void generate() throws Exception {
        RsaUtils.generateKey( 2048);
    }
    @Test
    public void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getPublicKey());
    }

    @Test
    public void getPrivateKey() throws Exception {
        System.out.println(RsaUtils.getPrivateKey());
    }


}
