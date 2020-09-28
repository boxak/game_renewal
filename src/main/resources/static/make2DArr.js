function make2DArr(rowSize,colSize,initial){
	var arr;
	var mat = [];
	for(var i=0;i<rowSize;i++){
		arr = [];
		for(var j=0;j<colSize;j++){
			arr[j] = initial;
		}
		mat[i] = arr;
	}
	return mat;
};