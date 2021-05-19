'''
result = []
def backtrack(Path, Seletion List):
    if meet the End Conditon:
        result.add(Path)
        return
    for seletion in Seletion List:
        select
        backtrack(Path, Seletion List)
        deselect
'''
#1. Permutations 

res = []
def permute(nums):
  track = []
  backtrack(nums, track)
  return res

def backtrack(nums, track):
  if len(nums) == len(track):
    res.append(track[:])
    return
  for i in range(len(nums)):
    if nums[i] in track:
      continue
    track.append(nums[i])
    backtrack(nums, track)
    track.pop(len(track) - 1)

print("Backtracking")
permute([1,2,3])
print(res)