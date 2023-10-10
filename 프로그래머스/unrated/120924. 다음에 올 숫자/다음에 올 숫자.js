function solution(common) {
    let answer = 0;
    const n = common.length;

    if (n < 2) {
        return -1;
    }

    const last = common[n - 1];
    const diff = common[1] - common[0];
    const ratio = common[1] / common[0];

    if (diff === common[n - 1] - common[n - 2]) {
        return last + diff;
    } else if (ratio === common[n - 1] / common[n - 2]) {
        return last * ratio;
    }

    return -1;
}
