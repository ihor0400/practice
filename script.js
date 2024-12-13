document.addEventListener("DOMContentLoaded", () => {
    fetch("schedule")
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById("schedule-container");
            const days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];

            days.forEach(day => {
                const dayDiv = document.createElement("div");
                dayDiv.innerHTML = `<h2>${day}</h2>`;
                const lessons = data.filter(lesson => lesson.dayOfWeek === day);
                lessons.forEach(lesson => {
                    const lessonDiv = document.createElement("div");
                    lessonDiv.textContent = `${lesson.groupName} - Lesson ${lesson.lessonNumber}, ${lesson.instructor}`;
                    dayDiv.appendChild(lessonDiv);
                });
                container.appendChild(dayDiv);
            });
        });
});
