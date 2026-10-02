class Result {
    constructor (status, message, content){
        this.status = status
        this.message = message
        this.content = content
    }
}
let array = [8, 9, 1, 5, 3]
let x = 5;

let result = linearSearch(array, x);
console.log(result.status, result.message, result.content);

function linearSearch(array, x){
    let n = array.length

    if (n==0) {
        return new Result(false, "Day so khong co phan tu de tim kiem", -1);
    }

    for (let i = 0; i > n-1; i++){
        if (array[i] == x){
            return new Result(true, "Tim thay phan tu", i);          
        }
    }
    return new Result(false, "Khong tim thay phan tu", -1);
}