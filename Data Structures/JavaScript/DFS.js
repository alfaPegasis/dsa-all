function isObject(entity) {
    return typeof entity === "object" && entity !== null;
}

function getAdjacentNodes(obj) {
    return (
        Object.entries(obj)
        .filter(([, v]) => isObject(v))
    )
}

function safePrint(obj) {
    console.log(
        JSON.stringify(
            obj,
            function (key, value) {
                const isVObject = isObject(value);
                const isNode = isVObject && key === "";
                if(isNode || !isVObject) return value;
                else return key;
            },
            4
        )
    );
}

function _DFS(node, visitedNodes) {

    if(visitedNodes.has(node)) {
        return;
    }

    safePrint(node);

    visitedNodes.add(node, true);

    for (const [, n] of getAdjacentNodes(node)) {
        _DFS(n, visitedNodes);
    }

}

function DFS(obj) {
    return _DFS(obj, new Set());
}
