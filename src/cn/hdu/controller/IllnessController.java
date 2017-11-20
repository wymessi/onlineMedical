package cn.hdu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hdu.exception.CustomException;
import cn.hdu.po.Illness;
import cn.hdu.service.IllnessService;

/**
 * 
 * @author wangye 处理所有与疾病有关的请求
 *
 */

@Controller
public class IllnessController {

	@Autowired
	@Qualifier("illnessService")
	private IllnessService illnessService;

	// 根据疾病ID查找illness
	@RequestMapping("/findIllnessById.action")
	public String findIllnessById(Model model, String illnessId) throws Exception {

		Illness illness = illnessService.findIllnessById(illnessId);
		if (illness == null) {
			throw new CustomException("数据库异常!");
		}
		model.addAttribute("illness", illness);
		return "illness/illness";
	}

	// 根据疾病名称查找illness
	@RequestMapping("/findillnessByName.action")
	public String findillnessByName(Model model, String name) throws Exception {

		Illness illness = illnessService.findillnessByName(name);
		illnessService.updateHeat(illness);
		if (illness == null) {
			throw new CustomException("没有符合的查询结果，请检查输入名称是否正确！");
		}
		model.addAttribute("illness", illness);
		return "illness/illness";
	}
}
