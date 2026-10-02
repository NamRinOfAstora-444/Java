class Result {
    constructor (status, message, content){
        this.status = status
        this.message = message
        this.content = content
    }
}

let array = [[7, 3, 6, 10], [9,10,3], [1, 3, 6]]

let result = findCommonElement(array)

console.log(result.status, result.message, result.content);

function findCommonElement(array) {
    if (!Array.isArray(array)) {
        return new Result(false, "Mảng đầu vào chứa phần tử không phải kiểu mảng, không kiểm tra phần tử trùng lặp", null);
    }

    let n = array.length

    if (n == 0) {
        return new Result(false, "Mảng đầu vào không có mảng con không kiểm tra phần tử trùng lặp", null);
    }

    let i = 0

    while (i < n) {
        if (!Array.isArray(array[i])) {
            return new Result(false, "Mảng đầu vào chứa phần tử không phải kiểu mảng, không kiểm tra phần tử trùng  lặp", null);
        }

        let m = array[i].length

        if (m == 0) {
            return new Result(false, "Mảng đầu vào chứa phần tử không phải kiểu mảng, không kiểm tra phần tử trùng  lặp", null);
        }

        let k = 0;

        while (k < m) {

            if (array[i][k] <= 0) {
                return new Result(
                    false, "Mảng con chứa phần tử không phải số tự nhiên, không kiểm tra phần tử trùng lặp",
                    null
                );
            }

            k++;
        }

        for(let k=0;k<m-1;k++) { 
            for (let p = k + 1; p< m; p++) {
                if(array[i][k]==array[i][p])
                {
                    return new Result( false,"mảng con chứa phần tử trùng lặp, không tiến hành kiểm tra phần tử trùng lặp" , null);
        
                }
                }
        }
        i++
    }

    let KQ = [];
    if (n === 1) {
        for (const value of array[0]) {
        KQ.push(value);
        }

    return new Result(
        true,
        "Chỉ có 1 mảng con",
        KQ);
    }

    let root = array[0];
    let count = root.length;
    let j = 0;

    while (j < count) {
        let temp = root[j];
        let i = 1;

        while (i < n) {

            let flag = false;

            let m = array[i].length;

            let k = 0;

            while (k < m) {

                if (array[i][k] === temp) {
                    flag = true;
                    break;
                }

                k++;
            }

            if (flag === true) {
                i++
            }

            else {break;}
        }
        if (i == n) {
            KQ.push(temp);
        }
        j++;
    }

    if (KQ.length > 0){
        return new Result(true, "Tìm thấy phần tử trùng:", KQ);
    }
        
    return new Result(false, "Khong Tim thay phan tu chung", KQ);
}