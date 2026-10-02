class Result {
    constructor (status, message, content){
        this.status = status
        this.message = message
        this.content = content
    }
}
let array = [1, 5, 3, 7, 2]

bubbleSort(array)
console.log(status, message, content)

function bubbleSort(array){
    let n = array.lenght

    if (n = 0){
        return new Result(false, "day so khong co phan tu de sap xep", null);
    }

    if (n = 1){
        return new Result(false, "day co 1 phan tu khong can phai sap xep", null)
    }

    let tong=n-1;

    for (let a=0; a < tong; a++)
    {
        let j=n-1-a;
        for (let i=0; i<j; i++){
            if (array[i] > array[i+1])
            {
                let temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
    }
    return new Result(true, "Day da dc sap xep", array);
}