const express = require('express');
const app = express();
const port = 3000;

const schedule = require('./schedule.json');


app.get('/', (req, res) => {
    res.send('Welcome to the Swimming Schedule Management System!');
});


app.get('/schedule', (req, res) => {
    res.json(schedule.MONDAY);
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
