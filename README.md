Task Tracker Web
Java + Spring Boot + SQL
Work in progress

Architecture (MVC)

Model: Task, Priority, Status — сущности и enum’ы домена задач.
View: src/main/resources/templates/index.html (Thymeleaf) — HTML-шаблон, рендерит список задач и формы.
Controller: HomeController — обрабатывает HTTP-запросы, кладёт данные в Model, делает redirect после POST.
Service: TaskService — бизнес-логика и хранение задач в памяти (in-memory), операции add/markDone/findById.

Request flow

GET / → HomeController.home() → model.addAttribute("tasks", taskService.getAll()) → рендер index.html
POST /tasks → HomeController.addTask() → taskService.add(...) → redirect:/
POST /tasks/done → HomeController.markTaskDone() → taskService.markDone(id) → redirect:/

Current features

Add task (title + priority)
View tasks list (title/priority/status)
Mark task as DONE