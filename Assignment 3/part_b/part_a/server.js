const express = require("express");
const app = express();
const path = require("path");
const router = express.Router();

// middleware
app.use(express.json());
app.use(express.static(path.join(__dirname, "public")));

// routes
router.get("/", (req, res) => {
  // res.render("index")
  res.sendFile(path.join(__dirname + '/index.html'));
});

app.use('/', router)

const PORT = 5000 || process.env.PORT;
app.listen(PORT, () => {
  console.log(`server started at ${PORT}`);
});
