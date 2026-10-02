let tg = 9
drawPineTree()
function drawPineTree() {
    if (!Number.isInteger(tg)) {
	    console.log("So tang cua goc phai la so nguyen")
    }

    if (tg <= 1) {
        console.log("So tang cua goc phai lon hon 1")
    }

    for (let i = 1; i <= tg; i++) {
        let kt = tg
        let line = "";

        for (let lt = 0; lt < kt; lt++) {
            line += " ";
        }
        line += "*";
        console.log(line);
    }
    
    let tan = tg

    for (let j = 1; j <= tan; j ++) {
        let tt = tan - j + 2;
        for (let i = 1; i <= tt; i++) {
            let line = "";
            let kt = (2*j + 2*i - 4) / 2;
            for (let lt =   0; lt < kt; lt ++) {
                line += " ";  
            }
            let ds = 2*(tt - i + 1) - 1;
            for (let ls = 0; ls < ds; ls ++) {		
                line += "*";
            }
            console.log(line);
        }
    }
}