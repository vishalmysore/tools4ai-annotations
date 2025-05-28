package io.github.vishalmysore.tools4ai;


import io.github.vishalmysore.a2a.domain.JsonRpcRequest;
import io.github.vishalmysore.common.server.SpringAwareJSONRpcController;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/** Expose the Json-RPC endpoint for the tasks
 *  This will handle all the JSON RPC Requests for a2a such as
 *  tasks/send
 *  tasks/get
 *  tasks/sendSubscribe
 *  tasks/cancel
 *  tasks/setPushNotification etc
 * */
@ConditionalOnProperty(name = "agent.secure.enabled", havingValue = "false", matchIfMissing = true)
@RestController
@RequestMapping("/")
@Log
public class MainEntryPoint extends SpringAwareJSONRpcController {


    @Autowired
    public MainEntryPoint(ApplicationContext applicationContext) {
        super(applicationContext);
    }
    @GetMapping
    public ModelAndView forwardToIndex() {

        return new ModelAndView("forward:/index.html");
    }

    @PostMapping
    public Object handleRpc(@RequestBody JsonRpcRequest request) {
        log.info(request.toString());
        Object result = super.handleRpc(request);
        log.info("Result: " + result);
        return result;
    }


}
