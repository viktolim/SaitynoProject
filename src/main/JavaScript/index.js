const express = require("express");
const bodyParser = require("body-parser");
const ejs = require("ejs");
const http = require('http');

const app = express();
app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({ extended: true }));


app.get("/", function (req, res) {
    res.render("film.ejs");
});

app.get("/play", function (req, res) {
    res.render("quiz.ejs",{ Msg: null });
});
app.listen(3000, function () {
    console.log("Server is running on port 3000");
});