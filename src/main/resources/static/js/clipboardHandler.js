document.addEventListener('DOMContentLoaded', function () {
    var clipboard = new ClipboardJS('#copyButton');

    clipboard.on('success', function(e) {
        var button = e.trigger;
        button.textContent = 'Сохранено';

        setTimeout(function() {
            button.textContent = 'plands.ru';
        }, 3000);  // Change text back after 3 seconds
    });

    clipboard.on('error', function(e) {
        console.error('Action:', e.action);
        console.error('Trigger:', e.trigger);
    });
});

