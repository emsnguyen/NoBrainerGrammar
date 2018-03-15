var question = document.querySelector('.question');
function speak() {
    var msg = new SpeechSynthesisUtterance(question.innerHTML);
    window.speechSynthesis.speak(msg);
}
speak();
var isTimeOut = false;
var x;
var timeLeft = 10;
var timer = document.querySelector('#timer');
function countdown() {
    // Update the count down every 1 second
    x = setInterval(function() {
        document.querySelector('#timer').innerHTML = timeLeft;
        timeLeft--;
        // If the count down is over, write some text 
        if (timeLeft < 0) {
            clearInterval(x);
            checkCorrectAnswerWhenTimeOut();
            timer.innerHTML = 'Hết giờ';
            notif.innerHTML = 'Rất tiếc bạn chưa trả lời được trong vòng 10s!';
        }
    }, 1000);
}
countdown();
function readAnswer(text) {
    var msg = new SpeechSynthesisUtterance(text);
    window.speechSynthesis.speak(msg);
}
var answer = document.querySelector(".answer");
var correctAnswer = document.querySelector('.correctAnswer');
var answerList = answer.querySelectorAll('div');
var showexplain = document.querySelector('.showexplain');
function checkCorrectAnswerWhenTimeOut() {
    correctAnswer.style.display = 'block';
    showexplain.style.display = 'block';
    showexplain.textContent = 'Xem giải thích nào';
    for (var i = 0; i < answerList.length; i++) {
        question.style.pointerEvents = 'none';
        answerList[i].style.pointerEvents = 'none';
        if (answerList[i].innerHTML.trim() === correctAnswer.innerHTML.trim()) {
            answerList[i].style.color = 'green';
        } else {
            answerList[i].style.color = 'red';
        }
    }
}
var notif = document.querySelector('#notif');
function checkUserChoice(choice) {
    clearInterval(x);
    checkCorrectAnswerWhenTimeOut();
    if (isTimeOut) {
        return;
    }
    if (choice.innerHTML.trim() === correctAnswer.innerHTML.trim()) {
        notif.innerHTML = 'Đúng rồi, bạn đúng là thiên tài!';
        var currentPoint = document.querySelector('#point');
        var iPoint = parseInt(currentPoint.innerHTML);
        console.log(iPoint);
        if (timeLeft > 7) {
            currentPoint.innerHTML = iPoint + 20;
        } else if (timeLeft > 4) {
            currentPoint.innerHTML = iPoint + 15;
        } else {
            currentPoint.innerHTML = iPoint + 10;
        }
    } else {
        notif.innerHTML = 'Sai rồi, tiếc quá. Xem giải thích nhé bạn';
    }
}
function showHideExplanation() {
    var explanation = document.querySelector('.explanation');
    if (showexplain.textContent === 'Ẩn giải thích') {
        showexplain.textContent = 'Hiện giải thích';
        explanation.style.display = 'none';
    } else { //đang hiện
        showexplain.textContent = 'Ẩn giải thích';
        explanation.style.display = 'block';
    }
}
function submitForm() {
    document.querySelector('form').submit();
}