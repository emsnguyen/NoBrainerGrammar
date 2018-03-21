var question = document.querySelector('.question');
function speak() {
    var text = question.innerHTML.replace(/_/g, '...');
    console.log(text);
    var msg = new SpeechSynthesisUtterance(text);
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
        timer.innerHTML = timeLeft;
        timeLeft--;
        // If the count down is over, write some text 
        if (timeLeft < 0) {
            clearInterval(x);
            checkCorrectAnswerWhenTimeOut();
            timer.innerHTML = 'Hết giờ';
            notif.style.display = "block";
            notif.innerHTML = 'Rất tiếc bạn chưa trả lời được trong vòng 10s!';
        }
    }, 1000);
}
countdown();
var synth = window.speechSynthesis;
function readAnswer(text) {
    var text = text.replace(/_/g, '...');
    console.log(text);
    var msg = new SpeechSynthesisUtterance(text);
    synth.speak(msg);
}
function cancelRead() {
    synth.cancel();
}
var userpoint = document.querySelector('#userpoint');
var answer = document.querySelector(".answer");
var isCorrect = document.querySelector("#isCorrect");
var correctAnswer = document.querySelector('.correctAnswer');
var answerList = answer.querySelectorAll('div');
var showexplain = document.querySelector('.showexplain');
var explanation = document.querySelector('.explanation');
var notif = document.querySelector('#notif');
function checkCorrectAnswerWhenTimeOut() {
    synth.cancel();
    question.style.pointerEvents = 'none';
    explanation.style.display = 'block';
    for (var i = 0; i < answerList.length; i++) {
        answerList[i].style.pointerEvents = 'none';
        if (answerList[i].innerHTML.trim() === correctAnswer.innerHTML.trim()) {
            answerList[i].style.color = 'green';
        } else {
            answerList[i].style.color = 'red';
        }
    }
}
document.addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode === 13) {
        document.querySelector("#next-question").click();
    }
});
function checkUserChoice(choice) {
    clearInterval(x);
    checkCorrectAnswerWhenTimeOut();
    if (isTimeOut) {
        return;
    }
    notif.style.opacity = 1;
    if (choice.innerHTML.trim() === correctAnswer.innerHTML.trim()) {
        notif.style.color = '#62f441';
        notif.innerHTML = 'Đúng rồi, bạn đúng là thiên tài!';
        var currentPoint = document.querySelector('#point');
        var iPoint = parseInt(currentPoint.innerHTML);
        isCorrect.value = 'correct';
        console.log(iPoint);
        if (timeLeft > 7) {
            currentPoint.innerHTML = iPoint + 20;
        } else if (timeLeft > 4) {
            currentPoint.innerHTML = iPoint + 15;
        } else {
            currentPoint.innerHTML = iPoint + 10;
        }
        userpoint.value = currentPoint.innerHTML;
    } else {
        isCorrect.value = 'incorrect';
        notif.style.color = '#f44256';
        notif.innerHTML = 'Sai rồi, tiếc quá. Xem giải thích nhé bạn';
    }
}


function showExplanation() {
    explanation.style.display = "block";
}
function submitForm() {
    document.querySelector('.form').submit(); 
}
$(document).ready(function () {
    var parent = $(".answer");
    var divs = parent.children();
    while (divs.length) {
        parent.append(divs.splice(Math.floor(Math.random() * divs.length), 1)[0]);
    }
});