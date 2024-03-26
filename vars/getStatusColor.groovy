def call(currentResult) {
    switch (currentResult) {
        case 'SUCCESS':
            return 'green';
        case 'FAILURE':
            return 'red';
        case 'ABORTED':
            return 'grey';
        default:
            return 'black'; // default color
    }
}