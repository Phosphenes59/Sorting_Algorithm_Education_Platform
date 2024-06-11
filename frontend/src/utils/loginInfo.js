//存一下userId和token   token没有专门的值，这里就直接用userID的值代替了

export const storeUSER = (id) => {
    localStorage.setItem('USERID', id);
}

export const getUSER = () => {
    let userId = localStorage.getItem('USERID');
    if (userId) {
        return  userId;
    }
    return null;
}

export const removeUSER = () => {
    localStorage.removeItem('USERID');
}


export const getTOKEN = () => {
    let token = localStorage.getItem('USERID');
    if (token) {
        return  token;
    }
    return null;
}

