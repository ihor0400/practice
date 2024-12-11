const express = require('express');
const app = express();
const port = 3000; // Або будь-який інший порт, який ви використовуєте

// Графік уроків
const schedule = require('./schedule.json');

// Обробник для кореневого маршруту "/"
app.get('/', (req, res) => {
    res.send('Welcome to the Swimming Schedule Management System!');
});

// Додати обробник для перегляду розкладу
app.get('/schedule', (req, res) => {
    res.json(schedule.MONDAY); // Повертаємо графік на понеділок (або інші дні, якщо треба)
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
