const schedule = {
    Monday: [
        { lesson: "Swimming Basics", time: "10:00 AM", teacher: "Mr. Johnson" },
        { lesson: "Intermediate Swimming", time: "12:00 PM", teacher: "Ms. Smith" },
        { lesson: "Advanced Swimming", time: "2:00 PM", teacher: "Mr. Brown" },
        { lesson: "Diving Basics", time: "4:00 PM", teacher: "Ms. Davis" },
        { lesson: "Water Safety", time: "6:00 PM", teacher: "Dr. White" }
    ],
    Tuesday: [
        { lesson: "Breathing Techniques", time: "9:00 AM", teacher: "Mr. Black" },
        { lesson: "Swimming Fundamentals", time: "11:00 AM", teacher: "Ms. Green" },
        { lesson: "Stroke Improvement", time: "1:00 PM", teacher: "Dr. White" },
        { lesson: "Advanced Diving", time: "3:00 PM", teacher: "Mr. Brown" },
        { lesson: "Water Polo Basics", time: "5:00 PM", teacher: "Ms. Davis" }
    ],
    Wednesday: [
        { lesson: "Swimming Techniques", time: "10:00 AM", teacher: "Mr. Johnson" },
        { lesson: "Breathing Techniques", time: "12:00 PM", teacher: "Ms. Smith" },
        { lesson: "Competitive Swimming", time: "2:00 PM", teacher: "Mr. Brown" },
        { lesson: "Diving Basics", time: "4:00 PM", teacher: "Ms. Davis" },
        { lesson: "Water Safety", time: "6:00 PM", teacher: "Dr. White" }
    ],
    Thursday: [
        { lesson: "Stroke Techniques", time: "9:00 AM", teacher: "Mr. Black" },
        { lesson: "Swimming Endurance", time: "11:00 AM", teacher: "Ms. Green" },
        { lesson: "Advanced Diving", time: "1:00 PM", teacher: "Dr. White" },
        { lesson: "Water Polo Strategies", time: "3:00 PM", teacher: "Mr. Brown" },
        { lesson: "Water Safety", time: "5:00 PM", teacher: "Ms. Davis" }
    ],
    Friday: [
        { lesson: "Freestyle Swimming", time: "10:00 AM", teacher: "Mr. Johnson" },
        { lesson: "Breathing Techniques", time: "12:00 PM", teacher: "Ms. Smith" },
        { lesson: "Underwater Diving", time: "2:00 PM", teacher: "Mr. Brown" },
        { lesson: "Competitive Swimming", time: "4:00 PM", teacher: "Ms. Davis" },
        { lesson: "Water Polo Tactics", time: "6:00 PM", teacher: "Dr. White" }
    ]
};

const container = document.getElementById("schedule-container");

Object.keys(schedule).forEach(day => {
    const dayDiv = document.createElement("div");
    dayDiv.classList.add("day");
    dayDiv.innerHTML = `<h3>${day}</h3>`;
    schedule[day].forEach(lesson => {
        const lessonDiv = document.createElement("div");
        lessonDiv.classList.add("lesson");
        lessonDiv.innerHTML = `
            <span><strong>Lesson:</strong> ${lesson.lesson}</span>
            <span><strong>Time:</strong> ${lesson.time}</span>
            <span><strong>Teacher:</strong> ${lesson.teacher}</span>
        `;
        dayDiv.appendChild(lessonDiv);
    });
    container.appendChild(dayDiv);
});
