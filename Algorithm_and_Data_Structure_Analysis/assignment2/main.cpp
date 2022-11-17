#include <iostream>
#include <vector>
using namespace std;

class Node{

    public:
        // the number saved in a node
        int data;
        Node *root, *parent, *left, *right;
        // default constructor
        Node();
        // parametric constructor
        Node(int);
        // get height of a node
        int getHeight(Node*);
        // get balance value of a node
        int getBalanceValue(Node*);
        // four kinds of rotations
        Node* leftRotation(Node*);
        Node* rightRotation(Node*);
        Node* leftRightRotation(Node*);
        Node* rightLeftRotation(Node*);
        // inserting
        void insert(int);
        // recursive inserting
        void insertRec(Node*, int);
        // remove a node
        void remove(int);
        // remove recursively
        void removeRec(Node*, int);
        // preorder
        void printPreOrder(Node*);
        // postorder
        void printPostOrder(Node*);
        // inorder
        void printInOrder(Node*);
        // print the tree 
        void printTree(Node, string);
};

// default constructor
Node :: Node(){
    data = 0;
    root = parent = left = right = NULL;
}

// parametric constructor
Node :: Node(int num){
    data = num;
    root = parent = left = right = NULL;
}

// get height
int Node :: getHeight(Node *node){
    int height = -1;

    if(node != NULL){
        int left = getHeight(node->left);
        int right = getHeight(node->right);
        height = max(left, right) + 1;
    }

    return height;
}

// get balance value of a node
int Node :: getBalanceValue(Node *node){
    int balanceValue;
    // if no child
    if(node->left == NULL && node->right == NULL)
        balanceValue = 0;

    // one branch
    else if(node->left != NULL && node->right == NULL){
        int leftHeight = getHeight(node->left);
        balanceValue = leftHeight + 1;
    }

    else if(node->left == NULL && node->right != NULL){
        int rightHeight = getHeight(node->right);
        balanceValue = 0 - rightHeight - 1;
    }

    // two children
    else{
        int leftHeight = getHeight(node->left);
        int rightHeight = getHeight(node->right);
        balanceValue = leftHeight - rightHeight;
    }

    return balanceValue;
}

// left rotation
Node* Node :: leftRotation(Node *node){
    // save
    Node *newParent = node->right;
    Node *child = newParent->left;

    // rotate
    if(child != NULL)
        child->parent = node;
    node->right = child;   

    node->parent = newParent;
    newParent->left = node;

    return newParent;
}

// right rotation
Node* Node :: rightRotation(Node *node){
    // save
    Node *newParent = node->left;
    Node *child = newParent->right;

    // rotate
    if(child != NULL)
        child->parent = node;
    node->left = child;

    node->parent = newParent;
    newParent->right = node;

    return newParent;
}

// left-right rotation
Node* Node :: leftRightRotation(Node *node){
    node->left = leftRotation(node->left);
    node = rightRotation(node);

    return node;
}

// right-left rotation
Node* Node :: rightLeftRotation(Node *node){
    node->right = rightRotation(node->right);
    node = leftRotation(node);

    return node;
}

// insert a number in the tree
void Node :: insert(int num){
    // if the tree is empty
    if(root == NULL){
        root = new Node(num);
        root->parent = new Node(0);
    }

    // if not empty
    else{
        Node *current = root;
        return insertRec(current, num);
    }
}

// recursive insertion
void Node :: insertRec(Node *current, int num){
    // recursion
    if(num < current->data){
        // if left is empty
        if(current->left == NULL){
            current->left = new Node(num);
            current->left->parent = current;

            // now check balance value and rotate
        while(current != root){
            int balanceValue = getBalanceValue(current);
            Node *grandparent = current->parent;
            Node *tmp = current;

            if(balanceValue > 1){
                // get the height of children
                int leftChildHeight;
                int rightChildHeight;

                if(current->left->left != NULL)
                    leftChildHeight = getHeight(current->left->left);
                else if(current->left->left == NULL)
                    leftChildHeight = -1;

                if(current->left->right != NULL)
                    rightChildHeight = getHeight(current->left->right);
                else if(current->left->right == NULL)
                    rightChildHeight = -1;

                // right rotation
                if(leftChildHeight > rightChildHeight){
                    current = rightRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                    break;
                }

                // left-right rotation
                else if(leftChildHeight < rightChildHeight){
                    current = leftRightRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                    break;
                }
            }

            else if(balanceValue < -1){
                // get the height of children
                int leftChildHeight;
                int rightChildHeight;

                if(current->right->left != NULL)
                    leftChildHeight = getHeight(current->right->left);
                else if(current->right->left == NULL)
                    leftChildHeight = -1;

                if(current->right->right != NULL)
                    rightChildHeight = getHeight(current->right->right);
                else if(current->right->right == NULL)
                    rightChildHeight = -1;

                // right-left rotation
                if(leftChildHeight > rightChildHeight){
                    current = rightLeftRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                    break;
                }

                // left rotation
                else if(leftChildHeight < rightChildHeight){
                    current = leftRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                    break;
                }
            }
            current = current->parent; 
        }               

            // for the root              
            if(current == root){
                if(root->left == NULL && root->right == NULL)
                    return;
                
                else{
                    int balanceValue = getBalanceValue(root);

                    if(balanceValue > 1){
                        // get the height of children
                        int leftChildHeight;
                        int rightChildHeight;

                        if(root->left->left != NULL)
                            leftChildHeight = getHeight(root->left->left);
                        else if(root->left->left == NULL)
                            leftChildHeight = -1;

                        if(root->left->right != NULL)
                            rightChildHeight = getHeight(root->left->right);
                        else if(root->left->right == NULL)
                            rightChildHeight = -1;

                        // right rotation
                        if(leftChildHeight > rightChildHeight)
                            root = rightRotation(root);

                        // left-right rotation
                        else if(leftChildHeight < rightChildHeight)
                            root = leftRightRotation(root);
                    }

                    else if(balanceValue < -1){
                        // get the height of children
                        int leftChildHeight;
                        int rightChildHeight;

                        if(root->right->left != NULL)
                            leftChildHeight = getHeight(root->right->left);
                        else if(root->right->left == NULL)
                            leftChildHeight = -1;

                        if(root->right->right != NULL)
                            rightChildHeight = getHeight(root->right->right);
                        else if(root->right->right == NULL)
                            rightChildHeight = -1;

                        // right-left rotation
                        if(leftChildHeight > rightChildHeight)
                            root = rightLeftRotation(root);

                        // left rotation
                        else if(leftChildHeight < rightChildHeight)
                            root = leftRotation(root);
                    }
                }
            }
        }
                      
        else
            insertRec(current->left, num);
        
    }

    else if(num > current->data){
        // if right is empty
        if(current->right == NULL){
            current->right = new Node(num);
            current->right->parent = current;

        // now check balance value and rotate
        while(current != root){
            int balanceValue = getBalanceValue(current);
            Node *grandparent = current->parent;
            Node *tmp = current;

            if(balanceValue > 1){
                // get the height of children
                int leftChildHeight;
                int rightChildHeight;

                if(current->left->left != NULL)
                    leftChildHeight = getHeight(current->left->left);
                else if(current->left->left == NULL)
                    leftChildHeight = -1;

                if(current->left->right != NULL)
                    rightChildHeight = getHeight(current->left->right);
                else if(current->left->right == NULL)
                    rightChildHeight = -1;

                // right rotation
                if(leftChildHeight > rightChildHeight){
                    current = rightRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                    break;
                }

                // left-right rotation
                else if(leftChildHeight < rightChildHeight){
                    current = leftRightRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                    break;
                }
            }

            else if(balanceValue < -1){
                // get the height of children
                int leftChildHeight;
                int rightChildHeight;

                if(current->right->left != NULL)
                    leftChildHeight = getHeight(current->right->left);
                else if(current->right->left == NULL)
                    leftChildHeight = -1;

                if(current->right->right != NULL)
                    rightChildHeight = getHeight(current->right->right);
                else if(current->right->right == NULL)
                    rightChildHeight = -1;

                // right-left rotation
                if(leftChildHeight > rightChildHeight){
                    current = rightLeftRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                    break;
                }

                // left rotation
                else if(leftChildHeight < rightChildHeight){
                    current = leftRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                    break;
                }
            }
            current = current->parent; 
        }               

            // for the root              
            if(current == root){
                if(root->left == NULL && root->right == NULL)
                    return;
                
                else{
                    int balanceValue = getBalanceValue(root);

                    if(balanceValue > 1){
                        // get the height of children
                        int leftChildHeight;
                        int rightChildHeight;

                        if(root->left->left != NULL)
                            leftChildHeight = getHeight(root->left->left);
                        else if(root->left->left == NULL)
                            leftChildHeight = -1;

                        if(root->left->right != NULL)
                            rightChildHeight = getHeight(root->left->right);
                        else if(root->left->right == NULL)
                            rightChildHeight = -1;

                        // right rotation
                        if(leftChildHeight > rightChildHeight)
                            root = rightRotation(root);

                        // left-right rotation
                        else if(leftChildHeight < rightChildHeight)
                            root = leftRightRotation(root);
                    }

                    else if(balanceValue < -1){
                        // get the height of children
                        int leftChildHeight;
                        int rightChildHeight;

                        if(root->right->left != NULL)
                            leftChildHeight = getHeight(root->right->left);
                        else if(root->right->left == NULL)
                            leftChildHeight = -1;

                        if(root->right->right != NULL)
                            rightChildHeight = getHeight(root->right->right);
                        else if(root->right->right == NULL)
                            rightChildHeight = -1;

                        // right-left rotation
                        if(leftChildHeight > rightChildHeight)
                            root = rightLeftRotation(root);

                        // left rotation
                        else if(leftChildHeight < rightChildHeight)
                            root = leftRotation(root);
                    }
                }
            }
        }

        else
            insertRec(current->right, num);

    }

    // if the number is already in the tree
    else
        return;
}

// remove a number in the tree
void Node :: remove(int num){
    // if the tree is empty
    if(root == NULL)
        return;

    // if there is only one node in the tree
    else if(root->left == NULL && root->right == NULL){
        if(num == root->data)
            root = NULL;
        return;
    }

    else{
        Node *current = root;
        removeRec(current, num);
    }
}

// recursive removal
void Node :: removeRec(Node *current, int num){
    // if the node is not find in the tree
    if(current == NULL)
        return;

    if(num < current->data){
        removeRec(current->left, num);
    }

    else if(num > current->data){
        removeRec(current->right, num);
    }

    // if found
    else if(num == current->data){

        // no children
        if(current->left == NULL && current->right == NULL){
            current = current->parent;
            if(current->left != NULL && current->left->data == num)
                current->left = NULL;
            else if(current->right != NULL && current->right->data == num)
                current->right = NULL;
        }

        // only one child
        else if(current->left == NULL && current->right != NULL){
            // if current is root
            if(current == root){
                root->right->parent = root;
                root = root->right;
                root->parent = new Node(0);
                current = root;
            }
            else{         
                // connect nodes
                current = current->parent;
                
                if(current->left != NULL && current->left->data == num){
                    current->left = current->left->right;
                    current->left->parent = current;
                }
                if(current->right != NULL && current->right->data == num){
                    current->right = current->right->right;
                    current->right->parent = current;
                }
            }
        }

        else if(current->right== NULL && current->left != NULL){
            // if current is root
            if(current == root){
                root->left->parent = root;
                root = root->left;
                root->parent = new Node(0);
                current = root;
            }
            else{
                // connect nodes
                current = current->parent;
                if(current->left != NULL && current->left->data == num){
                    current->left = current->left->left;
                    current->left->parent = current;
                }
                if(current->right != NULL && current->right->data == num){
                    current->right = current->right->left;
                    current->right->parent = current;
                }
            }
        }

        // with two children
        else if(current->left != NULL && current->right != NULL){
            Node *copy = current->left;
            // find the largest one on the left side
            while(copy->right != NULL)
                copy = copy->right;
            current->data = copy->data;
            // if left child is copy
            if(current->left == copy){
                if(copy->left == NULL)
                    current->left = NULL;
                else{
                    current->left = copy->left;
                    current->left->parent = current;
                }
            }
            // if not
            else{
                if(copy->left == NULL)
                    copy->parent->right = NULL;
                else{
                    // connect nodes
                    copy->left->parent = copy->parent;
                    copy->parent->right = copy->left;
                }
            }

            current = copy->parent;
        }

        // now check balance value and rotate
        while(current != root){
            int balanceValue = getBalanceValue(current);
            Node *grandparent = current->parent;
            Node *tmp = current;

            if(balanceValue > 1){
                // get the height of children
                int leftChildHeight;
                int rightChildHeight;

                if(current->left->left != NULL)
                    leftChildHeight = getHeight(current->left->left);
                else if(current->left->left == NULL)
                    leftChildHeight = -1;

                if(current->left->right != NULL)
                    rightChildHeight = getHeight(current->left->right);
                else if(current->left->right == NULL)
                    rightChildHeight = -1;

                // right rotation
                if(leftChildHeight > rightChildHeight){
                    current = rightRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                }

                // left-right rotation
                else if(leftChildHeight < rightChildHeight){
                    current = leftRightRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                }
            }

            else if(balanceValue < -1){
                // get the height of children
                int leftChildHeight;
                int rightChildHeight;

                if(current->right->left != NULL)
                    leftChildHeight = getHeight(current->right->left);
                else if(current->right->left == NULL)
                    leftChildHeight = -1;

                if(current->right->right != NULL)
                    rightChildHeight = getHeight(current->right->right);
                else if(current->right->right == NULL)
                    rightChildHeight = -1;

                // right-left rotation
                if(leftChildHeight > rightChildHeight){
                    current = rightLeftRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                }

                // left rotation
                else if(leftChildHeight < rightChildHeight){
                    current = leftRotation(current);
                    current->parent = grandparent;
                    if(grandparent->left == tmp)
                        grandparent->left = current;
                    else if(grandparent->right == tmp)
                        grandparent->right = current;
                }
            }
            current = current->parent; 
        }               

            // for the root              
            if(current == root){
                if(root->left == NULL && root->right == NULL)
                    return;
                
                else{
                    int balanceValue = getBalanceValue(root);

                    if(balanceValue > 1){
                        // get the height of children
                        int leftChildHeight;
                        int rightChildHeight;

                        if(root->left->left != NULL)
                            leftChildHeight = getHeight(root->left->left);
                        else if(root->left->left == NULL)
                            leftChildHeight = -1;

                        if(root->left->right != NULL)
                            rightChildHeight = getHeight(root->left->right);
                        else if(root->left->right == NULL)
                            rightChildHeight = -1;

                        // right rotation
                        if(leftChildHeight > rightChildHeight)
                            root = rightRotation(root);

                        // left-right rotation
                        else if(leftChildHeight < rightChildHeight)
                            root = leftRightRotation(root);
                    }

                    else if(balanceValue < -1){
                        // get the height of children
                        int leftChildHeight;
                        int rightChildHeight;

                        if(root->right->left != NULL)
                            leftChildHeight = getHeight(root->right->left);
                        else if(root->right->left == NULL)
                            leftChildHeight = -1;

                        if(root->right->right != NULL)
                            rightChildHeight = getHeight(root->right->right);
                        else if(root->right->right == NULL)
                            rightChildHeight = -1;

                        // right-left rotation
                        if(leftChildHeight > rightChildHeight)
                            root = rightLeftRotation(root);

                        // left rotation
                        else if(leftChildHeight < rightChildHeight)
                            root = leftRotation(root);
                    }
                }
            }
    }
}

// print the tree in pre order
void Node :: printPreOrder(Node *root){
    if( root != NULL){
        cout << root->data << " ";
        printPreOrder(root->left);
        printPreOrder(root->right);
    }
}
// print the tree in post order
void Node :: printPostOrder(Node *root){
    if( root != NULL){
        printPostOrder(root->left);
        printPostOrder(root->right);
        cout << root->data << " ";
    }
}

// print the tree in in order
void Node :: printInOrder(Node *root){
    if( root != NULL){
        printInOrder(root->left);
        cout << root->data << " ";
        printInOrder(root->right);   
    }
}

// print the tree
void Node :: printTree(Node node, string order){
    Node *current = node.root;
    // if the tree is empty
    if(current == NULL){
        cout << "EMPTY" << endl;
        return;
    }
    if(order == "PRE")
        printPreOrder(current);
    else if(order == "POST")
        printPostOrder(current);
    else if(order == "IN")
        printInOrder(current);

}


int main(){

    // get the input
    string line;
    getline(cin, line);

    // variable of printing order
    string order = "";

    // node of tree
    Node node;

    // insert now
    for(std::vector<float>::size_type i = 0; i < line.length(); i++){
        if(line[i] == 'A'){
            string current = "";
            for(std::vector<float>::size_type j = i+1; j < line.length(); j++){
                if(line[j] != ' ')
                    current += line[j]; // push the numbers of insertion
                else if(line[j] == ' ')
                    break;
            }
            node.insert(stoi(current));
        }

        else if(line[i] == 'D'){
            string current = "";
            for(std::vector<float>::size_type j = i+1; j < line.length(); j++){
                if(line[j] != ' ')
                    current += line[j]; // push the numbers of deletion
                else if(line[j] == ' ')
                    break;
            }
            node.remove(stoi(current));
        }

        else if(line[i] == 'P' || line[i] == 'I'){
            for(std::vector<float>::size_type j = i; j < line.length(); j++)
                order += line[j];
        }
    }
    
    node.printTree(node, order);

    return 0;
}