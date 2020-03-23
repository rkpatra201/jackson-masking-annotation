import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.mask.handler.impl.DefaultMaskingHandlerImpl;
import com.java.mask.manager.MaskingHandlerManager;
import com.java.model.LoanAccount;
import com.java.model.Person;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        // mobile
//        String input1 = "(123) (556) 7890";
//        String regex1 = "\\d(?!\\d{0,3}$)";
//        System.out.println(input1.replaceAll(regex1,"*"));
//        // pan card
//        String input2 = "BOJPP6543L";
//        String regex2 = "[A-Z0-9](?![A-Z0-9]{0,3}$)";
//        System.out.println(input2.replaceAll(regex2,"*"));
//
//        String input3 = "rabindra@yahoo.in";
//        String regex3 = "(?<=.)[^@](?=[^@]*?@)|(?:(?<=@.)|(?!^)\\G(?=[^@]*$)).(?=.*\\.)";
//        System.out.println(input3.replaceAll(regex3,"*"));
//
//        // 3 characters from begin
//        // (?<=@...) 3 characters after encountering @
//        String regex4 ="(?<=...)[^@](?=[^@]*?@)|(?:(?<=@...)|(?!^)\\G(?=[^@]*$)).(?=.*\\.)";
//        System.out.println(input3.replaceAll(regex4,"*"));
        m1();
    }

    public static void m1() throws IOException
    {
        MaskingHandlerManager manager = MaskingHandlerManager.getInstance();
        manager.addHandler("bean1", new DefaultMaskingHandlerImpl());

        // 8374651-37374-19283-284745800-1234
        LoanAccount c = new LoanAccount("123456","1234123", new Exception());
        c.setMobileNumber(123890);
        Set<Number> mobileNumbers = new HashSet<Number>();
        mobileNumbers.add(123456);
        mobileNumbers.add(121456L);
        mobileNumbers.add(120456f);
        c.setMobileNumbers(mobileNumbers);

        Person p = new Person("john");
        c.setPerson(p);
        System.out.println(mapper.writeValueAsString(c));


    }

}

