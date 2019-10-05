/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.web.controller.v1
 * @ClassName: TbContentController
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:45
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.web.controller.v1;

import com.pzhu.my.shop.commons.dto.BaseResult;
import com.pzhu.my.shop.domain.TbContent;
import com.pzhu.my.shop.web.api.service.TbContentService;
import com.pzhu.my.shop.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:45
 * @description:
 */
@RestController
@RequestMapping(value = "${api.path.v1}/contents")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;

        if (id == null) {
            tbContent = new TbContent();
        }

        return tbContent;
    }

    /**
     * 幻灯片接口
     *
     * @return
     */
    @RequestMapping(value = "ppt", method = RequestMethod.GET)
    public BaseResult findPPT() {
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(89L);

        if (tbContents != null && tbContents.size() > 0) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO dto = new TbContentDTO();
                BeanUtils.copyProperties(tbContent, dto);
                tbContentDTOS.add(dto);
            }
        }

        return BaseResult.success("成功", tbContentDTOS);
    }
}
