import com.guet.weiliang.config.SpringMvcConfig;
import com.guet.weiliang.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liweiliang
 * @create 2023-10-03 16:05:16
 * @description
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringMvcConfig.class);
        System.out.println(context.getBean(UserController.class));
    }
}