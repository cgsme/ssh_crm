package cn.tutu.web.action;

import cn.tutu.domain.LinkMan;
import cn.tutu.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 联系人action
 *
 * Created by 曹贵生 on 2017/6/3.
 * Email: 1595143088@qq.com
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkMan linkMan = new LinkMan();
    private LinkManService linkManService;

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    /**
     * 添加联系人
     * @return
     * @throws Exception
     */
    public String add() throws Exception {

        linkManService.save(linkMan);
        return "toList";
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }
}
