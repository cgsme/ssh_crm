package cn.tutu.web.action;

import cn.tutu.domain.BaseDict;
import cn.tutu.service.BaseDictService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * 数据字典Action
 * Created by 曹贵生 on 2017/6/2.
 * Email: 1595143088@qq.com
 */
public class BaseDictAction extends ActionSupport {

    private String typeCode;
    private BaseDictService baseDictService;

    @Override
    public String execute() throws Exception {

        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        System.out.println(typeCode);
        try {
            List<BaseDict> baseDictList = baseDictService.findDictByTypeCode(typeCode);
            String json = JSONArray.fromObject(baseDictList).toString();
            // 将json数组写会客户端
            ServletActionContext.getResponse().getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 数据字典列表
     * @return
     * @throws Exception
     */
    public String list() throws Exception {

        return "list";
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }
}
