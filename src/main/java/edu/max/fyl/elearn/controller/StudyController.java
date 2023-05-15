package edu.max.fyl.elearn.controller;

import edu.max.fyl.elearn.dto.Lesson;
import edu.max.fyl.elearn.dto.Test;
import edu.max.fyl.elearn.service.LessonService;
import edu.max.fyl.elearn.service.TestService;
import edu.max.fyl.elearn.tools.TestResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudyController {

    private final LessonService lessonService;
    private final TestService testService;

    public StudyController(LessonService lessonService, TestService testService) {
        this.lessonService = lessonService;
        this.testService = testService;
    }

    @GetMapping(value = "/tests")
    public String showTestsPage(@RequestParam(required = false, name = "result") String result, Model model) {
        model.addAttribute("result", result);
        return "pages/tests";
    }

    @GetMapping(value = "/tests/{id}")
    public String showTestPageById(@PathVariable int id, Model model) {
        Test test = testService.getTestById(id);

        model.addAttribute("testResult", new TestResult());
        model.addAttribute("test", test);
        model.addAttribute("helpSentence", test.getHelpSentence());

        return "pages/test";
    }

    @PostMapping(value = "/result-test")
    public String calculateTestResult(RedirectAttributes redirectAttributes,
                                      @ModelAttribute TestResult testResult) {
        int count = testResult.calculateResult();
        redirectAttributes.addAttribute("result", count);

        return "redirect:/tests";
    }

    @GetMapping(value = "/lessons")
    public String showLessonsPage(Model model) {
        List<Lesson> lessons = lessonService.getAllLessons();
        model.addAttribute("data", lessons);

        return "pages/lessons";
    }

    @GetMapping(value = "/lessons/{id}")
    public String showLessonsPage(@PathVariable int id, Model model) {
        Lesson lesson = lessonService.getLessonById(id);
        String[] paragraphs = lesson.getText().split("\\n");

        model.addAttribute("topic", lesson.getTopic());
        model.addAttribute("paragraphs", paragraphs);

        return "pages/lesson";
    }
}
