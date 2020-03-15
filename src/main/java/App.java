import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.mask.manager.MaskingHandlerManager;
import com.java.mask.handler.impl.CreditCardMaskingHandlerImpl;
import com.java.mask.handler.impl.DebitCardMaskingHandlerImpl;
import com.java.model.LoanAccount;

import java.io.IOException;

public class App {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        MaskingHandlerManager manager = MaskingHandlerManager.getInstance();
        manager.addHandler("bean1", new CreditCardMaskingHandlerImpl());
        manager.addHandler("bean2", new DebitCardMaskingHandlerImpl());
        LoanAccount c = new LoanAccount("8374651-37374-19283-284745800","dghji");
        System.out.println(mapper.writeValueAsString(c));
    }

}

