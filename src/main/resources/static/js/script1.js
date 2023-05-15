// // Скрипт для поиска слов в словаре
const subscriptionKey = '';
const region = 'westeurope';
const endpoint = 'https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=uk';

const searchButton = document.querySelector('#search-button');
const definition = document.querySelector('.definition');

if (searchButton) {
    searchButton.addEventListener('click', function() {
        const searchInput = document.querySelector('#search');

        let word = searchInput.value.toLowerCase();
        let definitionText = '';

        fetch(`https://api.dictionaryapi.dev/api/v2/entries/en_US/${word}`)
            .then(response => response.json())
            .then(data => {
                // Если слово найдено, отображаем его определение
                const firstMeaning = data[0].meanings[0];
                definitionText = firstMeaning.definitions[0].definition;
                translateText(definitionText, definition);


                // Отображаем слово в верхней части страницы
                const wordSpan = document.querySelector('.word');
                word = word.replace(word.charAt(0),word.charAt(0).toUpperCase());
                translateText(word, wordSpan)

                searchInput.value = ''
            })
            .catch(error => {
                // Если слово не найдено, выводим сообщение об ошибке
                const wordSpan = document.querySelector('.word');
                wordSpan.textContent = '';
                definition.innerHTML = `<p>Слово "${word}" не найдено в словаре.</p>`;
            });
    });

}

function translateText(x, z) {
    const requestBody = [{
        'text': x
    }];


    const xhr = new XMLHttpRequest();
    xhr.open('POST', endpoint);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader('Ocp-Apim-Subscription-Key', subscriptionKey);
    xhr.setRequestHeader('Ocp-Apim-Subscription-Region', region);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            const response = JSON.parse(xhr.responseText);
            let translatedText = response[0].translations[0].text;
            if(definition === z){
                z.innerHTML = '🇺🇸<i>' + x + '</i><br>🇺🇦' + translatedText;
            } else{
                translatedText = translatedText.toLowerCase();
                z.innerHTML = x + ' - ' + translatedText;
            }

        }
    };
    xhr.send(JSON.stringify(requestBody));
}