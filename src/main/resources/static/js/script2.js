// // Получаем все слова со страницы словаря
// const words = document.querySelectorAll('.word');
//
// // Добавляем обработчик клика на каждое слово
// words.forEach((word) => {
//     word.addEventListener('click', () => {
//         // Получаем английское слово
//         const engWord = word.innerText;
//         // Создаем новый объект Audio для проигрывания звука
//         const audio = new Audio(`https://dictionary.com/${engWord}.mp3`);
//         // Проигрываем звук
//         audio.play();
//         alert('hi')
//     });
// });

var url = window.location.href;
let button = document.getElementById("button");
if (url.indexOf('?result') != -1) {
    button.setAttribute("style","visibility: visible");
}